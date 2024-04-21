import java.util.*;

public class HW05_20220808025 {
    public static void main(String[] args) {
        
    }

}
    interface Damageable {
        void takeDamage(int damage);

        void takeHealing(int healing);

        boolean isAlive();
    }

    interface Caster {
        void castSpell(Damageable target);

        void learnSpell(Spell spell);
    }

    interface Combat extends Damageable {
        void attack(Damageable target);

        void lootWeapon(Weapon weapon);
    }

    interface Useable {
        int use();
    }

    class Spell implements Useable {
        private int minHeal;
        private int maxHeal;
        private String name;

        public Spell(String name, int minHeal, int maxHeal) {
            setName(name);
            setMinHeal(minHeal);
            setMaxHeal(maxHeal);
        }

        public void setMinHeal(int minHeal) {
            this.minHeal = minHeal;
        }

        public void setMaxHeal(int maxHeal) {
            this.maxHeal = maxHeal;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        private int heal() {
            return (int) (Math.random() * (maxHeal - minHeal + 1) + minHeal);
        }

        public int use() {
            return heal();
        }
    }

    class Weapon implements Useable {
        private int minDamage;
        private int maxDamage;
        private String name;

        public Weapon(String name, int minDamage, int maxDamage) {
            setName(name);
            setMinDamage(minDamage);
            setMaxDamage(maxDamage);
        }

        public void setMaxDamage(int maxDamage) {
            this.maxDamage = maxDamage;
        }

        public void setMinDamage(int minDamage) {
            this.minDamage = minDamage;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        private int attack() {
            return (int) (Math.random() * (maxDamage - minDamage + 1) + minDamage);
        }

        public int use() {
            return attack();
        }
    }

    class Attributes {
        private int strength;
        private int intelligence;

        public Attributes() {
            setStrength(3);
            setIntelligence(3);
        }

        public Attributes(int strength, int intelligence) {
            setStrength(strength);
            setIntelligence(intelligence);
        }

        public void setIntelligence(int intelligence) {
            this.intelligence = intelligence;
        }

        public void setStrength(int strength) {
            this.strength = strength;
        }


        public int getStrength() {
            return strength;
        }

        public int getIntelligence() {
            return intelligence;
        }


        public void increaseStrength(int amount) {
            strength += amount;
        }

        public void increaseIntelligence(int amount) {
            intelligence += amount;
        }

        public String toString() {
            return "Attributes [Strength=" + strength + ", intelligence=" + intelligence + "]";
        }
    }

    abstract class Character implements Comparable<Character>, Damageable {
        private String name;
        protected int level;
        protected Attributes attributes;
        protected int health;

        public Character(String name, Attributes attributes) {
            setName(name);
            setAttributes(attributes);
            this.level = 1;
            this.health = 100;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Attributes getAttributes() {
            return attributes;
        }

        public void setAttributes(Attributes attributes) {
            this.attributes = attributes;
        }

        public String getName() {
            return name;
        }

        public int getLevel() {
            return level;
        }
        

        public abstract void levelUp();

        public String toString() {
            return getClass().getSimpleName() + " LvL: " + level + " - " + attributes;
        }

        public int compareTo(Character other) {

            return Integer.compare(this.level, other.level);
        }

        public void takeDamage(int damage) {
            health -= damage;
        }

        public void takeHealing(int healing) {
            health += healing;
        }

        public boolean isAlive() {

            return health > 0;
        }

    }

    abstract class PlayableCharacter extends Character {
        private boolean inParty;
        private Party party;

        public PlayableCharacter(String name, Attributes attributes) {
            super(name, attributes);
            this.inParty = false;
            this.party = null;
        }

        public boolean isInParty() {
            return inParty;
        }

        public void levelUp() {
            this.level += 1;

        }

        public void joinParty(Party party) throws AlreadyInPartyException, PartyLimitReachedException {
            if (inParty)
                throw new AlreadyInPartyException("Character is already in a party.");

            if (party.getFighters().size() + party.getHealers().size() >= Party.getPartyLimit())
                throw new PartyLimitReachedException("Party limit reached.");

            this.party = party;
            this.inParty = true;

            if (this instanceof Paladin)
                party.incrementMixedCount();
            else if (this instanceof Warrior)
                party.addCharacter(this);
            else if (this instanceof Cleric)
                party.addCharacter(this);
        }

        public void quitParty() throws CharacterIsNotInPartyException {
            if (!inParty)
                throw new CharacterIsNotInPartyException("Character is not in a party.");

            if (this instanceof Paladin)
                party.removeCharacter(this);
            else if (this instanceof Warrior)
                party.removeCharacter(this);
            else if (this instanceof Cleric)
                party.removeCharacter(this);

            this.party = null;
            this.inParty = false;
        }
    }

    abstract class NonPlayableCharacter extends Character {
        public NonPlayableCharacter(String name, Attributes attributes) {
            super(name, attributes);
        }

    }

    class Merchant extends NonPlayableCharacter {
        private Collection<Useable> inventory;

        public Merchant(String name) {
            super(name, new Attributes(0, 0));
            this.inventory = new ArrayList<>();
        }

        public void levelUp() {
            // Empty
        }

        public void display() {
            for (Useable useables : inventory) {
                System.out.println(useables);
            }
        }

        public Useable buy(int itemNumber) throws ItemNotFoundException {
            try {
                return ((List<Useable>) inventory).get(itemNumber);
            } catch (IndexOutOfBoundsException e) {
                throw new ItemNotFoundException("Item not found in inventory.");
            }
        }

        public void sell(Useable item) {
            inventory.add(item);
        }


    }

    class Skeleton extends NonPlayableCharacter implements Combat {
        public Skeleton(String name, Attributes attributes) {
            super(name, attributes);
        }

        public void lootWeapon(Weapon weapon) {
            // basically a setter method whatttt
        }

        public void takeHealing(int healing) {
            super.takeDamage(healing);

        }

        @Override
        public void levelUp() {
            this.level += 1;
            attributes.increaseStrength(1);
            attributes.increaseIntelligence(1);


        }

        public void attack(Damageable target) {
            target.takeDamage(attributes.getIntelligence() + attributes.getStrength());
        }
    }

    class Warrior extends PlayableCharacter implements Combat {
        private Useable weapon;

        public Warrior(String name) {
            super(name, new Attributes(4, 2));
            this.health = 35;
        }

        public void levelUp() {
            attributes.increaseStrength(2);
            attributes.increaseIntelligence(1);
        }

        public void lootWeapon(Weapon weapon) {
            this.weapon = weapon;
        }

        public void attack(Damageable target) {
            target.takeDamage(attributes.getStrength() + this.weapon.use());
        }
    }

    class Cleric extends PlayableCharacter implements Caster {
        private Useable spell;

        public Cleric(String name) {
            super(name, new Attributes(2, 4));
            this.health = 25;
        }

        public void levelUp() {
            attributes.increaseStrength(1);
            attributes.increaseIntelligence(2);
        }

        public void castSpell(Damageable target) {
            target.takeHealing(attributes.getIntelligence() + spell.use());
        }

        public void learnSpell(Spell spell) {
            this.spell = spell;
        }
    }

    class Paladin extends PlayableCharacter implements Combat, Caster {
        protected Useable weapon;
        protected Useable spell;

        public Paladin(String name) {
            super(name, new Attributes());
            this.health = 30;
        }

        public void levelUp() {
            levelUp();
            if (level % 2 == 0) {
                attributes.increaseStrength(2);
                attributes.increaseIntelligence(1);
            } else {
                attributes.increaseStrength(1);
                attributes.increaseIntelligence(2);
            }
        }

        public void lootWeapon(Weapon weapon) {
            this.weapon = weapon;
        }

        public void castSpell(Damageable target) {
            target.takeHealing(attributes.getIntelligence() + spell.use());
        }

        public void learnSpell(Spell spell) {
            this.spell = spell;
        }

        public void attack(Damageable target) {
            target.takeDamage(attributes.getStrength() + weapon.use());
        }
    }

    class Party {
        private static final int PARTY_LIMIT = 8;
        private List<PlayableCharacter> fighters;
        private List<PlayableCharacter> healers;
        private int mixedCount;

        public Party() {
            fighters = new ArrayList<>();
            healers = new ArrayList<>();
            mixedCount = 0;
        }

        public void incrementMixedCount() {
            this.mixedCount++;
        }

        public static int getPartyLimit() {
            return PARTY_LIMIT;
        }

        public List<PlayableCharacter> getHealers() {
            return healers;
        }

        public List<PlayableCharacter> getFighters() {
            return fighters;
        }

        public void addCharacter(PlayableCharacter character) throws PartyLimitReachedException {
            if (fighters.size() + healers.size() >= PARTY_LIMIT) {
                throw new PartyLimitReachedException("Party limit reached.");
            }

            if (character instanceof Paladin) {
                mixedCount++;
            }

            if (character instanceof Combat) {
                fighters.add((PlayableCharacter) character);
            }

            if (character instanceof Caster) {
                healers.add((PlayableCharacter) character);
            }
        }

        public void removeCharacter(PlayableCharacter character) throws CharacterIsNotInPartyException {
            if (character instanceof Combat) {
                if (!fighters.remove(character)) {
                    throw new CharacterIsNotInPartyException("Character is not in party.");
                }
            }

            if (character instanceof Caster) {
                if (!healers.remove(character)) {
                    throw new CharacterIsNotInPartyException("Character is not in party.");
                }
            }

            if (character instanceof Paladin) {
                mixedCount--;
            }
        }

        public void partyLevelUp() {

        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            List<Character> allCharacters = new ArrayList<>();
            allCharacters.addAll(fighters);
            allCharacters.addAll(healers);
            allCharacters.sort(Comparable::compareTo);

            for (Character character : allCharacters) {
                sb.append(character.toString()).append("\n");
            }

            return sb.toString();
        }

        public int getMixedCount() {
            return mixedCount;
        }
    }

    class PartyLimitReachedException extends Exception {
        public PartyLimitReachedException(String message) {
            super(message);
        }
    }

    class AlreadyInPartyException extends Exception {
        public AlreadyInPartyException(String message) {
            super(message);
        }
    }

    class CharacterIsNotInPartyException extends Exception {
        public CharacterIsNotInPartyException(String message) {
            super(message);
        }
    }

    class ItemNotFoundException extends Exception {
        public ItemNotFoundException(String message) {
            super(message);
        }
    }







