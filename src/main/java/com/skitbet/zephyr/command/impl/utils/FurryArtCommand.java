package com.skitbet.zephyr.command.impl.utils;

import com.skitbet.zephyr.command.ICommand;
import com.skitbet.zephyr.utils.JSONUtils;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FurryArtCommand extends ICommand {
    public FurryArtCommand(String name, String description) {
        super(name, description);
    }

    @Override
    public void run(SlashCommandInteractionEvent event) {
        event.deferReply().queue();

        String tag = event.getOption("tag").toString();

        try {
            JSONObject jsonObject = JSONUtils.readJsonFromUrl(new URL("https://e926.net/posts.json?tags=" + tag));
            int size = jsonObject.size();

            System.out.println(jsonObject.get("posts"));
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public List<OptionData> getOptions() {
        List<OptionData> optionData = new ArrayList<>();
        optionData.add(new OptionData(OptionType.STRING, "tag", "Tag to search", true));
        return optionData;
    }
}
