package com.github.gr1lzy.vcs_all_in_one.commands;

import com.github.gr1lzy.vcs_all_in_one.shell.Out;
import com.github.gr1lzy.vcs_all_in_one.vcs.VCSFacade;
import com.github.gr1lzy.vcs_all_in_one.vcs.VCSFactory;
import picocli.CommandLine.Command;

import java.util.ArrayList;
import java.util.concurrent.Callable;

@Command(name = "fetch", description = "Download objects and refs from another repository")
class Fetch implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        VCSFacade vcs;
        try {
            vcs = new VCSFactory().call();
        } catch (Exception e) {
            Out.error(e.getMessage());
            return 1;
        }

        ArrayList<String> output = vcs.fetch_remote();
        for (var line : output) {
            Out.log(line);
        }
        return 0;
    }
}
