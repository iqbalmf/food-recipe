package net.iqbalfauzan.network.custom

import javax.crypto.Cipher
import javax.crypto.spec.IvParameterSpec
import kotlin.experimental.xor


object Obfuscate {

    private lateinit var decoderCipher: Cipher

    //encoding = "UTF-8";
    private val encoding: String = decode(byteArrayOf(0xD5.toByte(), 0xD5.toByte(), 0xC4.toByte(), 0xAE.toByte(), 0xBC.toByte()))

    //algorithmAES = "AES"
    private val algorithmAES = decode(byteArrayOf(0xC1.toByte(), 0xC4.toByte(), 0xD1.toByte()))

    //trasformationAES = "AES/CBC/PKCS5Padding"
    private val trasformationAES = decode(byteArrayOf(0xC1.toByte(), 0xC4.toByte(), 0xD1.toByte(), 0xAC.toByte(), 0xC7.toByte(), 0xC7.toByte(), 0xC5.toByte(), 0xA8.toByte(), 0xD8.toByte(), 0xC2.toByte(), 0xC9.toByte(), 0xD8.toByte(), 0xB9.toByte(), 0xDD.toByte(), 0xEF.toByte(), 0xEB.toByte(), 0xF4.toByte(), 0xF8.toByte(), 0xFC.toByte(), 0xF4.toByte()))

    fun encode(str: String): ByteArray? {
        val data = str.toByteArray(charset("UTF-8"))
        for (i in data.indices) {
            data[i] = data[i] xor (0x80 + (i % 0x80)).toByte()
        }
        return data
    }

    fun decode(data: ByteArray): String {
        for (i in data.indices) {
            data[i] = data[i] xor (0x80 + (i % 0x80)).toByte()
        }
        return String(data, charset("UTF-8"))
    }

    @Synchronized
    fun AESDecoder(input: ByteArray): String {
        return String(AESDefuscate(input), charset(encoding))
    }

    @Synchronized
    fun AESDefuscate(input: ByteArray): ByteArray {
        decoderCipher = Cipher.getInstance(trasformationAES)
        decoderCipher.init(Cipher.DECRYPT_MODE, ObfuscatorKey(), IvParameterSpec(
            ObfuscatorKey.getDecoderIv(
                decoderCipher.blockSize
            )
        ))
        return decoderCipher.doFinal(input)
    }
}
