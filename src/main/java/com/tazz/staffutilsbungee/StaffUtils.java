package com.tazz.staffutilsbungee;

import com.tazz.staffutilsbungee.helpop.HelpOpCommand;
import com.tazz.staffutilsbungee.helpop.HelpOpManager;
import com.tazz.staffutilsbungee.listeners.JoinListener;
import com.tazz.staffutilsbungee.listeners.LeaveListener;
import com.tazz.staffutilsbungee.report.ReportCommand;
import com.tazz.staffutilsbungee.report.ReportManager;
import com.tazz.staffutilsbungee.staffchat.StaffChatCommand;
import com.tazz.staffutilsbungee.staffchat.StaffChatListener;
import com.tazz.staffutilsbungee.staffchat.StaffChatManager;
import lombok.Getter;
import net.md_5.bungee.api.plugin.Plugin;

public class StaffUtils extends Plugin {

    @Getter public static StaffUtils instance;
    @Getter public HelpOpManager helpOpManager;
    @Getter public ReportManager reportManager;
    @Getter public StaffChatManager staffChatManager;

    public void onEnable() {
        getProxy().getPluginManager().registerListener(this, new JoinListener());
        getProxy().getPluginManager().registerListener(this, new LeaveListener());
        getProxy().getPluginManager().registerListener(this, new StaffChatListener());

        getProxy().getPluginManager().registerCommand(this, new HelpOpCommand());
        getProxy().getPluginManager().registerCommand(this, new ReportCommand());
        getProxy().getPluginManager().registerCommand(this, new StaffChatCommand());

        registerManagers();
    }

    private void registerManagers() {
        this.helpOpManager = new HelpOpManager(this);
        this.reportManager = new ReportManager(this);
        this.staffChatManager = new StaffChatManager(this);
    }
}
