package evangamer2018.evantech.gui;

import evangamer2018.evantech.EvanTech;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModGUIs {

    public static ScreenHandlerType<ChargerScreenHandler> CRUDE_CHARGER_SCREEN_HANDLER;
    @SuppressWarnings("deprecation")
    public static void registerModGUIs() {
        CRUDE_CHARGER_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(EvanTech.MOD_ID, "crude_charger"), ChargerScreenHandler::new);
    }

    @SuppressWarnings("deprecation")
    public static void registerClientGUIs() {
        ScreenRegistry.register(CRUDE_CHARGER_SCREEN_HANDLER, ChargerScreen::new);
    }
}
