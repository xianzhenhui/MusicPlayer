
package com.tim.rename.main;

import com.tim.rename.impl.RenameImpl;

public class MainTest {

    private static RenameImpl szRenameImpl = null;

    public static void main(String[] args) {
        Init();
        if (getSzRenameImpl() != null) {
            String str = getSzRenameImpl().getRenameValue("sssss.....jpg", null);
            System.out.println("file name:" + str);
        } else {
            System.out.println("szRenameImpl isjnul");
        }
    }

    private static void Init() {
        String packageClassName;
        packageClassName = getPackageClassName();
        if (packageClassName != null && !packageClassName.equals("")) {
            try {
                Class c = Class.forName(packageClassName);
                if (c.newInstance() instanceof RenameImpl) {
                    szRenameImpl = (RenameImpl) c.newInstance();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("packageClassName:[" + packageClassName+"]");
        }
    }

    private static String getPackageClassName() {
        return "com.tim.rename.impl.RenameImpl";
    }

    public static RenameImpl getSzRenameImpl() {
        return szRenameImpl;
    }
}
