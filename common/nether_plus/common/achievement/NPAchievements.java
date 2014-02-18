package nether_plus.common.achievement;

import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import nether_plus.common.block.NPBlockList;

public class NPAchievements
{
	public static Achievement pickCorruptedCobblestone;
	public static Achievement pickGrimwoodLog;
	public static Achievement craftGrimwoodWorkbench;
	
	public static void loadAchievements()
	{
		pickCorruptedCobblestone = new Achievement("achievement.pickCorruptedCoblestone", "pickCorruptedCoblestone", -7, 7, NPBlockList.CorruptedCobblestone, AchievementList.portal).registerStat();
		pickGrimwoodLog = new Achievement("achievement.pickGrimwoodLog", "pickGrimwoodLog", -10, 7, NPBlockList.GrimwoodLog, pickCorruptedCobblestone).registerStat();
		craftGrimwoodWorkbench = new Achievement("achievement.craftGrimwoodWorkbench", "craftGrimwoodWorkbench", -13, 7, NPBlockList.GrimwoodWorkbench, pickGrimwoodLog).registerStat();
	}
}