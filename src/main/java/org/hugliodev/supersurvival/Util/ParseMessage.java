package org.hugliodev.supersurvival.Util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import me.clip.placeholderapi.PlaceholderAPI;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.jar.JarFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * This class provides the ability to parse colorcodes with an input of strings, Lists, JsonObjects
 * (witch will need to be strings or JsonArrays).
 * <p>
 * you are able to extract the string or list from this class using {@code toString()} and {@code toList}.
 * <p>
 * Extra placeholders will be applied when the parse is made.
 * <p>
 * Placeholders using the placeholderapi will be applied at the moment when the string or list is requested.
 * if the player isn't provided anywhere this class won't use the placeholderAPI and the classwill work without it
 * <p>
 * as you are only able to replace custom placeholders at parsetime is it posible with the method {@code extraPlaceholders()} without converting it to a list/string
 * <p>
 * this parsemessage supports hexcollors and gradiends, normal hex is done with {@code <#FFFFFF>} and for gradients{@code <#FFFFFF>text</#000000>}
 * @author Thehuglio
 * @version 1.0
 * @see PlaceholderAPI
 * @see org.bukkit.ChatColor
 * @Link <a href="https://htmlcolorcodes.com/">HTML collorpicker</a> for hexcolors
 */
public class ParseMessage implements Iterable<String> {

    /**
     * the player for the placeholderAPI
     */
    OfflinePlayer player = null;
    private String parsedString = null;
    private List<String> parsedList = null;


    //these first methods are for parsing lists

    /**
     * Gets a List with string and replaces placeholders colorcodes and hexcolors
     * @param strings takes a list of strings to parse
     * @param p takes a player for the placeholders
     * @param extraPlaceholders add extra local placeholders
     * @param value add replacements for the placeholders (index to index)
     */
    public ParseMessage(List<String> strings, OfflinePlayer p, String[] extraPlaceholders, String[] value) {
        List<String> strings1 = new ArrayList<>();
        this.player = p;
        for (String string : strings) {
            strings1.add(replacePlaceholders(color(string),extraPlaceholders,value));
        }
        parsedList = strings1;
    }

    /**
     * Gets a List with string and replaces extra placeholders colorcodes and hexcolors
     * @param strings takes a list of strings to parse
     * @param extraPlaceholders add extra local placeholders
     * @param value add replacements for the placeholders (index to index)
     */
    public ParseMessage(List<String> strings, String[] extraPlaceholders, String[] value) {
        List<String> strings1 = new ArrayList<>();
        for (String string : strings) {
            strings1.add(replacePlaceholders(color(string),extraPlaceholders,value));
        }
        parsedList = strings1;
    }

    /**
     * Parses a list with string and replaces placeholders, colorcodes and hexcolors
     * @param list the list to pase.
     * @param p the player for the placeholders.
     */
    public ParseMessage(List<String> list, OfflinePlayer p) {
        this.player = p;
        List<String> temp = new ArrayList<>();
        for (String s : list) {
            temp.add(color(s));
        }
        parsedList = temp;
    }

    /**
     * Gets a List with string and replaces colorcodes and hexcolors
     * @param strings takes a list of strings to parse
     */
    public ParseMessage(List<String> strings) {
        List<String> strings1 = new ArrayList<>();
        for (String string : strings) {
            strings1.add(color(string));
        }
        parsedList = strings1;
    }
    //these methods are for parsing single strings.

    /**
     * Gets a string and replaces extra placeholders,placeholders, colorcodes and hexcolors
     * @param s takes a list of strings to parse
     * @param p takes a player for the placeholders
     * @param extraPlaceholders add extra local placeholders
     * @param value add replacements for the placeholders (index to index)
     */
    public ParseMessage(String s, OfflinePlayer p, String[] extraPlaceholders, String[] value) {
        this.player = p;
        parsedString = color(replacePlaceholders(s,extraPlaceholders,value));
    }

    /**
     * Gets a string and replaces placeholders colorcodes and hexcolors
     * @param s takes a list of strings to parse
     * @param extraPlaceholders add extra local placeholders
     * @param value add replacements for the placeholders (index to index)
     */
    public ParseMessage(String s, String[] extraPlaceholders, String[] value) {
        parsedString = color(replacePlaceholders(s,extraPlaceholders,value));
    }

    /**
     * Gets a string and replaces colorcodes and hexcolors
     * @param s String to apply hex and colorcodes
     */

    public ParseMessage(String s) {
        parsedString = color(s);
    }

    /**
     * Gets a string and replaces colorcodes and hexcolors
     * @param s String to apply hex and colorcodes
     */

    public ParseMessage(String s, OfflinePlayer p) {
        this.player = p;
        parsedString = color(s);
    }

    //these part of the methods add JsonObject suport and suports the ability to use arrays and strings without having to convert them to strings

    /**
     * Gets a JsonObject and looks if it is an array it will be parsed as a list and otherwise parsed as a string
     * @param json takes a JsonObject of to parse
     * @param p takes a player for the placeholders
     * @param extraPlaceholders add extra local placeholders
     * @param value add replacements for the placeholders (index to index)
     */
    public ParseMessage(JsonObject json, OfflinePlayer p, String[] extraPlaceholders, String[] value) {
        this.player = p;
        List<String> temp = new ArrayList<>();
        if (json.isJsonArray()) {
            for (JsonElement jsonElement : json.getAsJsonArray()) {
                temp.add(color(replacePlaceholders(jsonElement.getAsString(),extraPlaceholders,value)));
            }
            parsedList = temp;
        } else {
            parsedString = color(replacePlaceholders(json.getAsString(), extraPlaceholders, value));
        }
    }

    /**
     * Gets a JsonObject and looks if it is a array it will be parsed as a list and otherwise parsed as a string
     * @param json takes a JsonObject to parse
     * @param extraPlaceholders add extra local placeholders
     * @param value add replacements for the placeholders (index to index)
     */
    public ParseMessage(JsonElement json, String[] extraPlaceholders, String[] value) {
        List<String> temp = new ArrayList<>();
        if (json.isJsonArray()) {
            for (JsonElement jsonElement : json.getAsJsonArray()) {
                temp.add(color(replacePlaceholders(jsonElement.getAsString(),extraPlaceholders,value)));
            }
            parsedList = temp;
        } else {
            parsedString = color(replacePlaceholders(json.getAsString(), extraPlaceholders, value));
        }
    }

    /**
     * Gets a JsonObject and looks if it is an array it will be parsed as a list and otherwise parsed as a string
     * @param json takes a JsonObject to parse
     */

    public ParseMessage(JsonElement json) {
        List<String> temp = new ArrayList<>();
        if (json.isJsonArray()) {
            for (JsonElement jsonElement : json.getAsJsonArray()) {
                temp.add(color(jsonElement.getAsString()));
            }
            parsedList = temp;
        } else {
            parsedString = color(json.getAsString());
        }
    }

    /**
     * Gets a JsonObject and looks if it is a array it will be parsed as a list and otherwise parsed as a string
     * @param json takes a JsonObject to parse
     */

    public ParseMessage(JsonElement json, OfflinePlayer p) {
        this.player = p;
        List<String> temp = new ArrayList<>();
        if (json.isJsonArray()) {
            for (JsonElement jsonElement : json.getAsJsonArray()) {
                temp.add(color(jsonElement.getAsString()));
            }
            parsedList = temp;
        } else {
            parsedString = color(json.getAsString());
        }
    }


    //the next methods cannot be used outside this class.
    //these methods are for parsing and replacing placeholders and collorcodes.

    /**
     * Replaces the internal strings or list with the provided placeholders and values (index to index)
     * @param placeholders Add local one time use placeholders.
     * @param value Add local one time use replacements for placeholders
     */
    private void replacePlaceholders(String[] placeholders,String[] value) {
        if (parsedString == null) {
            parsedList = replacePlaceholders(parsedList,placeholders,value);
        }
        parsedString = replacePlaceholders(parsedString,placeholders,value);
    }

    /**
     * Replaces the provided string with the provided placeholders and values (index to index)
     * @param s A string that needs to be replaced with the provided placeholders
     * @param placeholders Add local one time use placeholders.
     * @param value Add local one time use replacements for placeholders
     */
    private String replacePlaceholders(String s,String[] placeholders,String[] value) {
        for (int i = 0; i < placeholders.length; i++) {
            s = s.replace(placeholders[i],value[i]);
        }
        return s;
    }
    /**
     * Replaces the provided List of Strings with the provided placeholders and values (index to index)
     * @param list A List of Strings that needs to be replaced with the provided placeholders
     * @param placeholders Add local one time use placeholders.
     * @param value Add local one time use replacements for placeholders
     */
    private List<String> replacePlaceholders(List<String> list,String[] placeholders,String[] value) {
        List<String> temp = new ArrayList<>();
        for (String s : list) {
            for (int i = 0; i < placeholders.length; i++) {
                s = s.replace(placeholders[i], value[i]);
            }
            temp.add(s);
        }
        return temp;
    }


    /**
     * the gradient-parenting for the gradient support
     */
    private final Pattern gradientPattern = Pattern.compile("<#([a-fA-F0-9]{6})>(.*?)</#([a-fA-F0-9]{6})>");
    /**
     * the normal pattern for the hex support
     */
    private final Pattern simplePattern = Pattern.compile("<#[a-fA-F0-9]{6}>");
    /**
     *
     * @param s parse a message for color and gradient hex
     * @return returns the parsed string
     */
    private String color(String s) {
        // Pattern to match gradient hex color tags and simple hex color tags


        Matcher gradientMatcher = gradientPattern.matcher(s);
        while (gradientMatcher.find()) {
            // Extract start color, text, and end color for gradients
            String startHex = gradientMatcher.group(1);
            String text = gradientMatcher.group(2);
            String endHex = gradientMatcher.group(3);

            // Generate gradient text
            String gradientText = applyGradient(text, startHex, endHex);

            // Replace the matched portion with the gradient text
            s = s.replace(gradientMatcher.group(0), gradientText);
            gradientMatcher = gradientPattern.matcher(s);
        }

        Matcher simpleMatcher = simplePattern.matcher(s);
        while (simpleMatcher.find()) {
            String hexCode = s.substring(simpleMatcher.start(), simpleMatcher.end());
            String replaceSharp = hexCode.replace('#', 'x');

            StringBuilder builder = new StringBuilder();
            for (char c : replaceSharp.toCharArray()) {
                builder.append("&").append(c);
            }

            s = s.replace(hexCode, builder.toString());
            simpleMatcher = simplePattern.matcher(s);
        }

        // Replace color codes with Minecraft formatting codes
        return ChatColor.translateAlternateColorCodes('&', s).replace('&', '§').replace("\"", "").replace("Â", "");
    }

    /**
     * adds gradiands to all the parsed strings
     * @param text text to parse
     * @param startHex the first hexcode
     * @param endHex the ending hexcode
     */
    private static String applyGradient(String text, String startHex, String endHex) {
        int length = text.length();
        StringBuilder builder = new StringBuilder();

        // Parse hex colors
        int startRed = Integer.parseInt(startHex.substring(0, 2), 16);
        int startGreen = Integer.parseInt(startHex.substring(2, 4), 16);
        int startBlue = Integer.parseInt(startHex.substring(4, 6), 16);

        int endRed = Integer.parseInt(endHex.substring(0, 2), 16);
        int endGreen = Integer.parseInt(endHex.substring(2, 4), 16);
        int endBlue = Integer.parseInt(endHex.substring(4, 6), 16);

        // Interpolate colors and build gradient text
        for (int i = 0; i < length; i++) {
            float ratio = (float) i / (length - 1);
            int red = (int) (startRed + ratio * (endRed - startRed));
            int green = (int) (startGreen + ratio * (endGreen - startGreen));
            int blue = (int) (startBlue + ratio * (endBlue - startBlue));

            String hexColor = String.format("#%02x%02x%02x", red, green, blue);
            String replaceSharp = hexColor.replace('#', 'x');

            StringBuilder colorCode = new StringBuilder();
            for (char c : replaceSharp.toCharArray()) {
                colorCode.append("&").append(c);
            }

            builder.append(colorCode).append(text.charAt(i));
        }

        return builder.toString();
    }
    private @Nonnull String PlaceholderAPIReplace(String s) {
        if (player != null) {
            return PlaceholderAPI.setPlaceholders(player, s);
        }
        return s;
    }
    private @NotNull List<String> PlaceholderAPIReplace(List<String> s) {
        if (player != null) {
            return PlaceholderAPI.setPlaceholders(player, s);
        }
        return s;
    }
    private @Nonnull String PlaceholderAPIReplace(String s,OfflinePlayer p) {
        return PlaceholderAPI.setPlaceholders(p, s);
    }
    private @NotNull List<String> PlaceholderAPIReplace(List<String> s,OfflinePlayer p) {
        return PlaceholderAPI.setPlaceholders(p, s);
    }

    //this method lets players add extra placeholders after the message is parsed.
    //this makes it posible for messages to be stored in this method and altered with placeholders

    /**
     * Replaces extra placeholders without parsing it through color code again making it faster than creating a new parseMessage. The index of the placeholder needs to be equal to the index of the value.
     * @param placeholders a list of the placeholders that need to be replaced
     * @param value a list of values that need to go instead of the placeholders.
     */
    public void extraPlaceholders(String[] placeholders,String[] value) {
        if (parsedString == null) {
            parsedList = replacePlaceholders(parsedList,placeholders,value);
        }
        parsedString = replacePlaceholders(parsedString,placeholders,value);
    }

    /**
     * sets a player for the placeholders of PlaceholderAPI
     * @param player set a player for the placeholders
     */
    public void setPlayer(OfflinePlayer player) {
        this.player = player;
    }
    //these methods return different kinds of values from the input depending on the method

    /**
     * returns a string that is parsed. if the input was a List this will result in a string with lines (\n)
     * @return Returns a String
     */
    @Override
    @Nonnull
    public String toString() {
        if (parsedString == null) {
            lConvert();
        }
        return PlaceholderAPIReplace(parsedString);
    }

    /**
     * returns a list of strings and if a single string has been put in it will return a list split with \n.
     * @return Returns a list with strings.
     */
    public List<String> toList() {
        if (parsedList == null) {
            sConvert();
        }
        return PlaceholderAPIReplace(parsedList);
    }
    /**
     * returns a string that is parsed. if the input was a List this will result in a string with lines (\n)
     * @return Returns a String
     */

    public String toString(OfflinePlayer p) {
        if (parsedString == null) {
            lConvert();
        }
        return PlaceholderAPIReplace(parsedString,p);
    }

    /**
     * returns a list of strings and if a single string has been put in it will return a list split with \n.
     * @return Returns a list with strings.
     */
    public List<String> toList(OfflinePlayer p) {
        if (parsedList == null) {
            sConvert();
        }
        return PlaceholderAPIReplace(parsedList,p);
    }
    /**
     * returns a string that is parsed. if the input was a List this will result in a string with lines (\n)
     * @return Returns a String
     */

    public String toString(OfflinePlayer p,String[] placeholders,String[] value) {
        if (parsedString == null) {
            lConvert();
        }
        return replacePlaceholders(PlaceholderAPIReplace(parsedString,p),placeholders,value);
    }

    /**
     * returns a list of strings and if a single string has been put in it will return a list split with \n.
     * @return Returns a list with strings.
     */
    public List<String> toList(OfflinePlayer p,String[] placeholders,String[] value) {
        if (parsedList == null) {
            sConvert();
        }
        return replacePlaceholders(PlaceholderAPIReplace(parsedList),placeholders,value);
    }
    /**
     * returns a string that is parsed. if the input was a List this will result in a string with lines (\n)
     * @return Returns a String
     */

    public String toString(String[] placeholders,String[] value) {
        if (parsedString == null) {
            lConvert();
        }
        return replacePlaceholders(PlaceholderAPIReplace(parsedString),placeholders,value);
    }

    /**
     * returns a list of strings and if a single string has been put in it will return a list split with \n.
     * @return Returns a list with strings.
     */
    public List<String> toList(String[] placeholders,String[] value) {
        if (parsedList == null) {
            sConvert();
        } return replacePlaceholders(PlaceholderAPIReplace(parsedList), placeholders, value);
    }

    //the util to change a string to a list a string to list
    private void lConvert() {
        StringBuilder stringBuilder = new StringBuilder();
        parsedList.forEach(s -> stringBuilder.append(s).append("\n"));
        parsedString = stringBuilder.toString();
    }
    private void sConvert() {
        parsedList = Arrays.stream(parsedString.split("\n")).toList();
    }
    public boolean isEmpty() {
        return parsedList.isEmpty() && parsedString == null;
    }

    @NotNull
    @Override
    public Iterator<String> iterator() {
        return toList().iterator();
    }
}
