package red.jad.dropspread;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.fabricmc.fabric.api.gamerule.v1.rule.DoubleRule;
import net.minecraft.world.GameRules;
import org.apache.logging.log4j.LogManager;

public class DropSpread implements ModInitializer {

	public static GameRules.Key<DoubleRule> DROP_SPREAD = GameRuleRegistry.register(
			"dropSpread",
			GameRules.Category.DROPS,
			GameRuleFactory.createDoubleRule(0.1D, 0, 10)
	);

	@Override
	public void onInitialize() {
		LogManager.getLogger("dropspread").info("Drop Spread initialized");
	}
}
