package net.iqbalfauzan.network.custom

import javax.crypto.spec.SecretKeySpec
import kotlin.experimental.xor


class ObfuscatorKey : SecretKeySpec(key, decode(byteArrayOf(0xC1.toByte(), 0xC4.toByte(), 0xD1.toByte()))) {
    companion object {
        private val key = byteArrayOf(0x28.toByte(), 0x73.toByte(), 0xC7.toByte(), 0xDD.toByte(), 0xA0.toByte(), 0xA2.toByte(), 0x70.toByte(), 0x07.toByte(), 0xDC.toByte(), 0xC8.toByte(), 0x69.toByte(), 0x08.toByte(), 0x46.toByte(), 0xAD.toByte(), 0x98.toByte(), 0x1B.toByte(), 0x50.toByte(), 0x6C.toByte(), 0xA4.toByte(), 0xE7.toByte(), 0xAC.toByte(), 0xFB.toByte(), 0xE1.toByte(), 0x59.toByte(), 0xE9.toByte(), 0xF9.toByte(), 0x43.toByte(), 0xC1.toByte(), 0x5F.toByte(), 0xE2.toByte(), 0x5B.toByte(), 0xEA.toByte())

        private fun decode(data: ByteArray): String? {
            for (i in data.indices) {
                data[i] = data[i] xor (0x80 + (i % 0x80)).toByte()
            }
            return String(data, charset("UTF-8"))
        }

        fun getDecoderIv(blocksize: Int): ByteArray {
            val iv = ByteArray(blocksize)
            var i = 0
            while (i < iv.size && i < key.size) {
                iv[i] = key[i] xor (0x80 + (i % 0x7f)).toByte()
                i++
            }
            return iv
        }
    }
}
