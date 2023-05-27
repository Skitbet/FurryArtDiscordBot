package com.skitbet.zephyr.command.impl.utils;

import com.skitbet.zephyr.command.ICommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import java.awt.*;
import java.util.Date;
import java.util.stream.Collectors;

public class StatusCommand extends ICommand {

    public StatusCommand(String name, String description) {
        super(name, description);
    }

    @Override
    public void run(SlashCommandInteractionEvent event) {

        Guild guild = event.getGuild();
        Member owner = guild.getOwner();

        int announcementChannels = guild.getNewsChannels().size();
        int categories = guild.getCategories().size();
        int textChannels = guild.getTextChannels().size();
        int voiceChannels = guild.getVoiceChannels().size();
        int forumChannels = guild.getForumChannels().size();

        EmbedBuilder embedBuilder = new EmbedBuilder()
                .setColor(Color.green)
                .addField("Members", "```" + guild.getMembers().stream().filter(member -> !member.getUser().isBot()).collect(Collectors.toList()).size() + "```", true)
                .addField("Bots", "```" + guild.getMembers().stream().filter(member -> member.getUser().isBot()).collect(Collectors.toList()).size() + "```", true)
                .addField("Is NSFW", "```" + (guild.getNSFWLevel().getKey() > 0 ? "No" : "Yes") + "```", true)
                .addField("Vanity Link", "```" + (guild.getVanityUrl() == null ? "No Vanity" : guild.getVanityUrl()) + "```", true)
                .addField("Categories", "```" + categories + "```", true)
                .addField("Announcement Channels", "```" + announcementChannels + "```", true)
                .addField("Text Channels", "```" + textChannels + "```", true)
                .addField("Voice Channels", "```" + voiceChannels + "```", true)
                .addField("Forums Channels", "```" + forumChannels + "```", true)

                .addField("Owner", owner.getAsMention(), true)
                .addField("Created", "<t:" + guild.getTimeCreated().toEpochSecond() + ":R>", true)
                .setTitle(guild.getName() + " Statistics")
                .setDescription(guild.getDescription());

        event.replyEmbeds(embedBuilder.build()).queue();


    }
}
