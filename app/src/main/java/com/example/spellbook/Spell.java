package com.example.spellbook;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import io.vavr.collection.HashSet;
import io.vavr.collection.List;
import io.vavr.collection.Map;
import io.vavr.collection.Set;

import com.fasterxml.jackson.jr.ob.JSON;
import com.fasterxml.jackson.jr.ob.JSONObjectException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Spell {
    private String spellName;
    private Integer spellLevel;
    private List<String> casterClasses;
    private String spellRange;
    private String castTime;
    private String effectDuration;
    private Boolean isRitual;
    private Boolean isConcentration;
    private String magicSchool;
    private String spellEffects;
    private String spellLevelBoost;
    private String spellDamage;
    // spellDamage is represented in string format [Q]d[S],[T][etc] such that:
        // [Q] is an integer representing the number of a type of dice to be rolled
        // d is a separator for [Q] and [S]
        // [S] is an integer representing the number of faces on the type of dice to be rolled
        // , is a separator for [S] and [T]
        // [T] is a string representing the damage type associated with the dice rolls corresponding to the first two letters of a damage type:
            // ac -> acid, bl -> bludgeoning, co -> cold, fi -> fire, fo -> force, li -> lightning, ne -> necrotic,
            // pi -> piercing, po -> poison, ps -> psychic, ra -> radiant, sl -> slashing, th -> thunder
        // [etc] will be either:
            // an absence of additional characters in the string if all damaging effects are present
            // a semicolon to act as a separator followed by another damaging effect in the same format
    private List<Character> componentTypes; // V -> Verbal, S -> Somatic, M -> Material
    private String materialsNeeded; // Only needs to be applied if [componentTypes] contains 'M'

    public Spell(String spellNameIn, Integer spellLevelIn){
        spellName = spellNameIn;
        spellLevel = spellLevelIn;
    }

    public String getSpellName() {
        return spellName;
    }

    public void setSpellName(String spellName) {
        this.spellName = spellName;
    }

    public Integer getSpellLevel() {
        return spellLevel;
    }

    public void setSpellLevel(Integer spellLevel) {
        this.spellLevel = spellLevel;
    }

    public List<String> getCasterClasses() {
        return casterClasses;
    }

    public void setCasterClasses(List<String> casterClasses) {
        this.casterClasses = casterClasses;
    }

    public String getSpellRange() {
        return spellRange;
    }

    public void setSpellRange(String spellRange) {
        this.spellRange = spellRange;
    }

    public String getCastTime() {
        return castTime;
    }

    public void setCastTime(String castTime) {
        this.castTime = castTime;
    }

    public String getEffectDuration() {
        return effectDuration;
    }

    public void setEffectDuration(String effectDuration) {
        this.effectDuration = effectDuration;
    }

    public Boolean getRitual() {
        return isRitual;
    }

    public void setRitual(Boolean ritual) {
        isRitual = ritual;
    }

    public Boolean getConcentration() {
        return isConcentration;
    }

    public void setConcentration(Boolean concentration) {
        isConcentration = concentration;
    }

    public String getMagicSchool() {
        return magicSchool;
    }

    public void setMagicSchool(String magicSchool) {
        this.magicSchool = magicSchool;
    }

    public String getSpellEffects() {
        return spellEffects;
    }

    public void setSpellEffects(String spellEffects) {
        this.spellEffects = spellEffects;
    }

    public String getSpellLevelBoost() {
        return spellLevelBoost;
    }

    public void setSpellLevelBoost(String spellLevelBoost) {
        this.spellLevelBoost = spellLevelBoost;
    }

    public String getSpellDamage() {
        return spellDamage;
    }

    public void setSpellDamage(String spellDamage) {
        this.spellDamage = spellDamage;
    }

    public List<Character> getComponentTypes() {
        return componentTypes;
    }

    public void setComponentTypes(List<Character> componentTypes) {
        this.componentTypes = componentTypes;
    }

    public String getMaterialsNeeded() {
        return materialsNeeded;
    }

    public void setMaterialsNeeded(String materialsNeeded) {
        this.materialsNeeded = materialsNeeded;
    }

//    static String readStoredSpellsFile() throws FileNotFoundException {
//        String output = "";
//        try {
//            File jsonFile = new File("res/json-data/spells.json");
//            Scanner myReader = new Scanner(jsonFile);
//            while(myReader.hasNextLine()) {
//                output = output.concat(myReader.nextLine());
//            }
//            myReader.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("NO FILE HERE.....");
//            e.printStackTrace();
//        }
//        return output;
//    }


    static List<Spell> readAllSpells(){
//        String jsonString = readStoredSpellsFile();
        JSONParser par = new JSONParser();
        List<Spell> spells = List.empty();
        try (FileReader reader = new FileReader("res/json-data/spells.json")) {
            Object obj = par.parse(reader);
            JSONObject jsonOb = (JSONObject) obj;
            HashSet<String> keys = HashSet.ofAll(jsonOb.keySet());

            while(keys.headOption().isDefined()){
                JSONObject spell = (JSONObject) jsonOb.get(keys.head());
                String name = keys.head();
                Integer level = (Integer) spell.get("Spell Level");
                spells = spells.append(new Spell(name, level));
                // fill in other properties here
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return spells;
    }


}
