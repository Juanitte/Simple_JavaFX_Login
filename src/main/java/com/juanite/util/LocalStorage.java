package com.juanite.util;

import com.juanite.model.RepoAccount;

import java.io.*;

public class LocalStorage {

    public static boolean write(RepoAccount accounts) {
        boolean result = false;

        try {
            FileOutputStream fileOut =
                    new FileOutputStream("src/main/java/com.juanite/Accounts.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(accounts);
            out.close();
            fileOut.close();
        } catch (IOException ignored) {

        }

        return result;
    }

    public static RepoAccount read() {

        RepoAccount accounts;

        try {
            FileInputStream fileIn = new FileInputStream("src/main/java/com.juanite/Accounts.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            accounts = (RepoAccount) in.readObject();
            in.close();
            fileIn.close();
            return accounts;
        } catch (IOException | ClassNotFoundException i) {

            return null;
        }

    }

}
