package com.github.gr1lzy.vcs_all_in_one.shell;

public class Out {
    public static void log(Object x) {
        System.out.println(x);
    }

    public static void debug(String x) {
        System.out.println(Colors.ANSI_YELLOW + x + Colors.ANSI_RESET);
    }

    public static void error(String x) {
        System.out.println(Colors.ANSI_RED + x + Colors.ANSI_RESET);
    }
}
