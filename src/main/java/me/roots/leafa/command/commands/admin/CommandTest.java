package me.roots.leafa.command.commands.admin;

import me.roots.leafa.command.managers.LeafaCommand;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class CommandTest extends LeafaCommand {

    public CommandTest() {
        super (
                "test",
                "BOT_OWNER",
                "Um simples comando para testar os comandos!"
        );
    }

    @Override
    public void run(MessageReceivedEvent event, String[] args) {
        if (!event.getAuthor().getDiscriminator().equalsIgnoreCase("3156")) {
            event.getChannel().sendMessage(":x: Você não tem a permissão: **BOT_OWNER** para executar este comando :x:").queue();
            return;
        }else{
            System.out.println("Leafa Console > Test Sucessful!");
        }
    }
}
