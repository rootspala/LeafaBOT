package me.roots.leafa.command.pivaman;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public abstract class LeafaCommand
{
    private String cmdName;

    private String cmdDescription;

    private String cmdPermission;

    public LeafaCommand(String name, String permission, String description) {
        this.cmdName = name;
        this.cmdDescription = description;
        this.cmdPermission = permission;
    }

    public String getName() {
        return this.cmdName;
    }

    public String getDescription() {
        return this.cmdDescription;
    }

    public String getPermission() {
        return this.cmdPermission;
    }

    public abstract void run(MessageReceivedEvent e, String[] args);
}
