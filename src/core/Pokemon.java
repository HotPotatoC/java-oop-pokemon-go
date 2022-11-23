package core;

import utils.Destructible;

public enum Pokemon implements Destructible {
        BULBASAUR("Bulbasaur", "001", new Stats(5, 10, (int) Math.random() * 10, 45),
                        new Type[] { Type.GRASS, Type.POISON }),
        CHARMANDER("Charmander", "004", new Stats(5, 10, (int) Math.random() * 10, 45),
                        new Type[] { Type.FIRE }),
        SQUIRTLE("Squirtle", "007", new Stats(5, 10, (int) Math.random() * 10, 45),
                        new Type[] { Type.WATER }),
        CATERPIE("Caterpie", "010", new Stats(5, 10, (int) Math.random() * 10, 45),
                        new Type[] { Type.BUG }),
        PIDGEY("Pidgey", "016", new Stats(5, 10, (int) Math.random() * 10, 45),
                        new Type[] { Type.NORMAL, Type.FLYING }),
        RATATA("Ratata", "019", new Stats(5, 10, (int) Math.random() * 10, 45),
                        new Type[] { Type.NORMAL }),
        EKANS("Ekans", "023", new Stats(5, 10, (int) Math.random() * 10, 45),
                        new Type[] { Type.POISON }),
        PIKACHU("Pikachu", "025", new Stats(5, 10, (int) Math.random() * 10, 45),
                        new Type[] { Type.ELECTRIC }),
        NIDORAN("Nidoran", "029", new Stats(5, 10, (int) Math.random() * 10, 45),
                        new Type[] { Type.POISON }),
        VULPIX("Vulpix", "037", new Stats(5, 10, (int) Math.random() * 10, 45),
                        new Type[] { Type.FIRE }),
        JIGGLYPUFF("Jigglypuff", "039", new Stats(5, 10, (int) Math.random() * 10, 45),
                        new Type[] { Type.NORMAL }),
        ZUBAT("Zubat", "041", new Stats(5, 10, (int) Math.random() * 10, 45),
                        new Type[] { Type.POISON, Type.FLYING }),
        ODDISH("Oddish", "043", new Stats(5, 10, (int) Math.random() * 10, 45),
                        new Type[] { Type.GRASS, Type.POISON }),
        DIGLETTS("Digletts", "050", new Stats(5, 10, (int) Math.random() * 10, 45),
                        new Type[] { Type.GROUND }),
        MEOWTH("Meowth", "052", new Stats(5, 10, (int) Math.random() * 10, 45),
                        new Type[] { Type.NORMAL }),
        PSYDUCK("Psyduck", "054", new Stats(5, 10, (int) Math.random() * 10, 45),
                        new Type[] { Type.WATER }),
        GROWLITHE("Growlithe", "058", new Stats(5, 10, (int) Math.random() * 10, 45),
                        new Type[] { Type.FIRE }),
        POLIWAG("Poliwag", "060", new Stats(5, 10, (int) Math.random() * 10, 45),
                        new Type[] { Type.WATER }),
        ABRA("Abra", "063", new Stats(5, 10, (int) Math.random() * 10, 45),
                        new Type[] { Type.PSYCHIC }),
        KADABRA("Kadabra", "064", new Stats(5, 10, (int) Math.random() * 10, 45),
                        new Type[] { Type.PSYCHIC }),
        ALAKAZAM("Alakazam", "065", new Stats(5, 10, (int) Math.random() * 10, 45),
                        new Type[] { Type.PSYCHIC }),
        MACHOP("Machop", "066", new Stats(5, 10, (int) Math.random() * 10, 45),
                        new Type[] { Type.FIGHTING }),
        GEODUDER("Geoduder", "074", new Stats(5, 10, (int) Math.random() * 10, 45),
                        new Type[] { Type.ROCK, Type.GROUND }),
        PONYTA("Ponyta", "077", new Stats(5, 10, (int) Math.random() * 10, 45),
                        new Type[] { Type.FIRE }),
        RAPIDASH("Rapidash", "078", new Stats(5, 10, (int) Math.random() * 10, 45),
                        new Type[] { Type.FIRE });

        private String name, pokedexNumber;
        private Stats stats;
        private Type[] types;

        Pokemon() {
        }

        Pokemon(String name, String pokedexNumber, Stats stats, Type[] types) {
                this.name = name;
                this.pokedexNumber = pokedexNumber;
                this.stats = stats;
                this.types = types;
        }

        public String getName() {
                return name;
        }

        public String getPokedexNumber() {
                return pokedexNumber;
        }

        public Stats getStats() {
                return stats;
        }

        public Type[] getTypes() {
                return types;
        }

        public void destroy() {
                this.name = null;
                this.pokedexNumber = null;
                this.stats = null;
                this.types = null;
        }
}