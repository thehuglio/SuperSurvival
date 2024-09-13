this plugin supports all kinds of adjustments within the configuration, underneeth is a full documentation for the whole config and datafiles.


Extra configuration Features and limitations:

Hexcollors, all messages in this config support hex collors with the format <#FFFFFF> and gradients with the format <#FFFFFF>text</#FFFFFF>
Multiline, all messages support array format and string format. for example:
        "testmessage": "this is line 1\n this is line 2"
        "testmessage": [
                        "this is line 1",
                        "this is line 2"
                        ]
These 2 messages will both display a 2 line message. this apply's to: messages, lore and all other text configurations that has multiline support from minecraft themselves
For the rest all defoult datatypes shouldnt be changed. so for example: 1 and "1" are both different types because the first one is an integer and the second one a string and cant be replaced by eachother, you can change the values to a different number or different text
The quotation marks are always strings (they support messages and text between the quotation marks) while numbers will only be changeable with other numbers;
Keep in mind that when a number has no decimals by default this won't be supported if you change them.
If a number is higher than 2,147,483,647 or lower than -2,147,483,647 it will not be supported. this is becouse of javas 32bit integer system and will need to be changed internaly if higher or lower numbers need to be suported
extra placeholders will be specified in the notes, in playermessages all placeholders will be suported from placeholderAPI

MainConfig:
    ChatSettings:
        enabled: in order to disable or enable this feature the server needs to be rebooted
        playerchatformat: The format for all players, (use placeholderAPI for placeholders, use %message% for the message
        allowplayercollorcodes: This allows players to use collorcodes and gradients
        allowplayerplaceholders: This allows players to use placeholders (only able to enable when allowplayercollorcodes is true) WARNING: This makes players able to use all placeholders of all plugins
        ChatItemListing: This allows players to use the ItemListing tool witch shows the item they are currently holding
        ChatItemListingFormat: This is the format players can use to specify an item witch will be displayed in chat
        ChatItemListingReplace: This is how the item will be displayed in chat NOTE: "%material%" will display the material of the item
        blockedWords: Blocks words from chat (if you want to only ban 1 word but not the same word in bigger words like "ass" but not "assemble" you can add a space in front or after the word or both depending on your configuration needs)
        bleurBlockedWords: If this is off the message will be deleted instead of replaced by the bleurtoken
        bleurtoken: The symbol that a bleurd word will be replaced by (every letter of the word will be replaced by this token
        blockedPunishement: everything in this list is a command and will be executed in concole (use PlaceholderAPI for playernames)
