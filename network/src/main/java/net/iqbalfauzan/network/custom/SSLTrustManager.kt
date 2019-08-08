package net.iqbalfauzan.network.custom

import java.security.KeyStore
import java.security.KeyStoreException
import java.security.NoSuchAlgorithmException
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import javax.net.ssl.TrustManagerFactory
import javax.net.ssl.X509TrustManager


class SSLTrustManager @Throws(NoSuchAlgorithmException::class, KeyStoreException::class)
constructor(keystore: KeyStore) : X509TrustManager {
    private var standardTrustManager: X509TrustManager

    init {
        val factory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm())
        factory.init(keystore)
        if (factory.trustManagers.isEmpty()) {
            throw NoSuchAlgorithmException("no trust manager found")
        }
        this.standardTrustManager = factory.trustManagers[0] as X509TrustManager
    }

    @Throws(CertificateException::class)
    override fun checkClientTrusted(certificates: Array<X509Certificate>, authType: String) {
        standardTrustManager.checkClientTrusted(certificates, authType)
    }

    @Throws(CertificateException::class)
    override fun checkServerTrusted(certificates: Array<X509Certificate>?, authType: String) {
        if (certificates != null && certificates.size == 1) {
            certificates[0].checkValidity()
        } else {
            standardTrustManager.checkServerTrusted(certificates, authType)
        }
    }

    override fun getAcceptedIssuers(): Array<X509Certificate> {
        return this.standardTrustManager.acceptedIssuers
    }
}
