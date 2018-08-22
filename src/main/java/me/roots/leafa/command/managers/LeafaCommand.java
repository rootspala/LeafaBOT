package me.roots.leafa.command.managers;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public abstract class LeafaCommand {

    private String commandName;
    private String commandPermission;
    private String commandDescription;

    public LeafaCommand(String name, String permission, String description) {
        this.commandName = name;
        this.commandPermission = permission;
        this.commandDescription = description;
    }

    public String getName() {
        return this.commandName;
    }

    public String getDescription() {
        return this.commandDescription;
    }

    public String getPermission() {
        return this.commandPermission;
    }

    public abstract void run(MessageReceivedEvent event, String[] args);

}
