package net.bifewagyu;

import net.bifewagyu.tops.GetTopTracks;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        System.out.println("Vamos ver sua lista de tracks famosas no seu spotify ");
        System.out.println();



        GetTopTracks getTopTracks = new GetTopTracks();

        getTopTracks.receberToken();

    }
}