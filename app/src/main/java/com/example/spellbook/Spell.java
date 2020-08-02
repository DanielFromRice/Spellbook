package com.example.spellbook;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import io.vavr.collection.List;

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

}
