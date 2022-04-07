package sk.plaut.ChatApp.utility;

import sk.plaut.ChatApp.ciphers.*;

import java.util.HashMap;

public class Utility {
    private static HashMap<String, Ciphers> cipherMap;

    public void initHashMap() {
        Utility.setCipherMap(new HashMap<>());
        Utility.getCipherMap().put("RightRightShift", new RightRightShift());
        Utility.getCipherMap().put("RightShift", new RightShift());
        Utility.getCipherMap().put("RSA", new RSA());
    }

	public static HashMap<String, Ciphers> getCipherMap() {
		return cipherMap;
	}

	public static void setCipherMap(HashMap<String, Ciphers> cipherMap) {
		Utility.cipherMap = cipherMap;
	}

}
