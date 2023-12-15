package com.github.gr1lzy.vcs_all_in_one.vcs.hg;

import com.github.gr1lzy.vcs_all_in_one.shell.CommandArg;
import com.github.gr1lzy.vcs_all_in_one.shell.CommandBuilder;
import com.github.gr1lzy.vcs_all_in_one.shell.CommandLine;

import java.util.ArrayList;
import java.util.concurrent.Callable;

class HgAdd implements Callable<ArrayList<String>> {
    private final ArrayList<String> files;

    public HgAdd(ArrayList<String> files) {
        this.files = files;
    }

    @Override
    public ArrayList<String> call() throws Exception {
        CommandBuilder builder = Hg.hgBuilder().addArguments(new CommandArg("add"));
        this.files.stream().map(CommandArg::new).forEach(builder::addArguments);

        return new CommandLine(builder).call();
    }
}
