package me.roots.leafa.command.commands.info;

import me.roots.leafa.command.managers.Command;
import me.roots.leafa.utils.BotClass;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.*;

public class CommandBotInfo implements Command {


    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        User user = event.getAuthor();

        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setColor(Color.GREEN);
        embedBuilder.setAuthor(user.getName(), user.getAvatarUrl(), user.getAvatarUrl());
        embedBuilder.setDescription(":question: Informações da BOT:");
        embedBuilder.addField(":woman: Nome de Usuário:", event.getJDA().getSelfUser().getName(), false);
        embedBuilder.addField(":gear: Versão do JDA:", "3.7.1_397", false);
        embedBuilder.addField(":exclamation: Prefix Universal:", ":regional_indicator_l::exclamation:", false);
        embedBuilder.addField("Nacionalidade:", ":flag_jp: Japão - Japan", false);
        embedBuilder.addField(":interrobang: ping:", String.valueOf(event.getJDA().getPing()), false);
        embedBuilder.setFooter("Em breve mais informações...", user.getAvatarUrl());
        event.getChannel().sendMessage(embedBuilder.build()).queue();
    }

    @Override
    public void executed(boolean sucessful, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }

}
