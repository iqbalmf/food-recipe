package net.iqbalfauzan.network.custom

import java.net.Socket
import java.security.*
import java.security.cert.X509Certificate
import javax.net.ssl.KeyManagerFactory
import javax.net.ssl.X509KeyManager


class SSLKeyManager @Throws(NoSuchAlgorithmException::class, UnrecoverableKeyException::class, KeyStoreException::class)
constructor(keystore: KeyStore, password: CharArray) : X509KeyManager {
    private var standardKeyManager: X509KeyManager

    init {
        val factory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm())
        factory.init(keystore, password)
        if (factory.keyManagers.isEmpty()) {
            throw NoSuchAlgorithmException("no trust manager found")
        }
        this.standardKeyManager = factory.keyManagers[0] as X509KeyManager
    }

    override fun chooseClientAlias(paramArrayOfString: Array<String>, paramArrayOfPrincipal: Array<Principal>, paramSocket: Socket): String? {
        val alias = this.standardKeyManager.chooseClientAlias(paramArrayOfString, paramArrayOfPrincipal, paramSocket)
        return if (alias.isNullOrEmpty())
            certalias
        else
            alias
    }

    override fun chooseServerAlias(paramString: String,
                                   paramArrayOfPrincipal: Array<Principal>, paramSocket: Socket): String {
        return this.standardKeyManager.chooseServerAlias(paramString, paramArrayOfPrincipal, paramSocket)
    }

    override fun getCertificateChain(paramString: String): Array<X509Certificate> {
        return this.standardKeyManager.getCertificateChain(paramString)
    }

    override fun getClientAliases(paramString: String,
                                  paramArrayOfPrincipal: Array<Principal>): Array<String> {
        return this.standardKeyManager.getClientAliases(paramString, paramArrayOfPrincipal)
    }

    override fun getServerAliases(paramString: String,
                                  paramArrayOfPrincipal: Array<Principal>): Array<String> {
        return this.standardKeyManager.getServerAliases(paramString, paramArrayOfPrincipal)
    }

    override fun getPrivateKey(paramString: String): PrivateKey {
        return this.standardKeyManager.getPrivateKey(paramString)
    }

    companion object {
        private val certificatealias = byteArrayOf(0x3C.toByte(), 0x0D.toByte(), 0x76.toByte(), 0xFA.toByte(), 0x95.toByte(), 0x86.toByte(), 0x92.toByte(), 0xFD.toByte(), 0x1B.toByte(), 0x62.toByte(), 0x05.toByte(), 0x43.toByte(), 0xCD.toByte(), 0x89.toByte(), 0xB1.toByte(), 0xE0.toByte())
        private val certalias = Obfuscate.AESDecoder(certificatealias)
    }
}
