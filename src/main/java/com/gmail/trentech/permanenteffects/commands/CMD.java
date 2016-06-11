package com.gmail.trentech.permanenteffects.commands;

import org.spongepowered.api.effect.potion.PotionEffectTypes;

public class CMD {

	public static class Absorbtion extends CMDBase {
		public Absorbtion() {
			super("absorbtion", "absorbtion", PotionEffectTypes.ABSORPTION);
		}		
	}
	
	public static class Blind extends CMDBase {
		public Blind() {
			super("blind", "blindness", PotionEffectTypes.BLINDNESS);
		}		
	}	
	
	public static class Fire extends CMDBase {
		public Fire() {
			super("fire", "fire_resistance", PotionEffectTypes.FIRE_RESISTANCE);
		}		
	}
	
	public static class Haste extends CMDBase {
		public Haste() {
			super("haste", "haste", PotionEffectTypes.HASTE);
		}		
	}
	
	public static class Health extends CMDBase {
		public Health() {
			super("health", "health_boost", PotionEffectTypes.HEALTH_BOOST);
		}		
	}
	
	public static class Hunger extends CMDBase {
		public Hunger() {
			super("hunger", "hunger", PotionEffectTypes.HUNGER);
		}		
	}
	
	public static class Fatigue extends CMDBase {
		public Fatigue() {
			super("fatigue", "mining_fatigue", PotionEffectTypes.MINING_FATIGUE);
		}		
	}

	public static class Invisible extends CMDBase {
		public Invisible() {
			super("invisible", "invisibility", PotionEffectTypes.INVISIBILITY);
		}		
	}
	
	public static class Jump extends CMDBase {
		public Jump() {
			super("jump", "jump_boost", PotionEffectTypes.JUMP_BOOST);
		}		
	}
	
	public static class Night extends CMDBase {
		public Night() {
			super("night", "night_vision", PotionEffectTypes.NIGHT_VISION);
		}		
	}
	
	public static class Regen extends CMDBase {
		public Regen() {
			super("regen", "regeneration", PotionEffectTypes.REGENERATION);
		}		
	}
	
	public static class Resist extends CMDBase {
		public Resist() {
			super("resist", "resistance", PotionEffectTypes.RESISTANCE);
		}		
	}
	
	public static class Saturation extends CMDBase {
		public Saturation() {
			super("saturation", "saturation", PotionEffectTypes.SATURATION);
		}		
	}
	
	public static class Slow extends CMDBase {
		public Slow() {
			super("slow", "slowness", PotionEffectTypes.SLOWNESS);
		}		
	}
	
	public static class Speed extends CMDBase {
		public Speed() {
			super("speed", "speed", PotionEffectTypes.SPEED);
		}		
	}
	
	public static class Strength extends CMDBase {
		public Strength() {
			super("strength", "strength", PotionEffectTypes.STRENGTH);
		}		
	}
	
	public static class Water extends CMDBase {
		public Water() {
			super("water", "water_breathing", PotionEffectTypes.WATER_BREATHING);
		}		
	}
	
	public static class Weak extends CMDBase {
		public Weak() {
			super("weak", "weakness", PotionEffectTypes.WEAKNESS);
		}		
	}
	
	public static class Wither extends CMDBase {
		public Wither() {
			super("wither", "wither", PotionEffectTypes.WITHER);
		}		
	}
}