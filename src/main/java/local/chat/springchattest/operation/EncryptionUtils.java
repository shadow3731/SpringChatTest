package local.chat.springchattest.operation;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class EncryptionUtils {

    private static final String ALGORITHM = "AES";
    private static final byte[] KEY = Arrays
            .copyOf("Chat27Secret54Key81"
                    .getBytes(StandardCharsets.UTF_8), 16);

    public static byte[] encrypt(byte[] input) throws Exception {
        byte[] inputBytes = new String(input).getBytes(StandardCharsets.UTF_8);

        SecretKeySpec secretKeySpec = new SecretKeySpec(KEY, ALGORITHM);

        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

        return cipher.doFinal(inputBytes);
    }

    public static byte[] decrypt(byte[] encryptedBytes) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(KEY, ALGORITHM);

        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);

        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

        return new String(decryptedBytes, StandardCharsets.UTF_8)
                .getBytes(StandardCharsets.UTF_8);
    }
}

