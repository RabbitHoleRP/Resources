package br.com.rabbithole.resources.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;

public class StringUtils {
    public static Component format(String input) {
        return MiniMessage.miniMessage().deserialize(input);
    }
}
