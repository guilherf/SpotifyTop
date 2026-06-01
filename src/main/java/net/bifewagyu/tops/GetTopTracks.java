package net.bifewagyu.tops;


import org.apache.hc.core5.http.ParseException;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.model_objects.specification.Track;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class GetTopTracks {



    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private String token = getToken();


   static SpotifyApi spotifyApi; ;



    Scanner sc = new Scanner(System.in);


    public void receberToken() {

        System.out.println("Digite o Token: ");
        String koken = sc.nextLine();

        inicializarAPI(koken);

        buscarMusica();





        sc.close();



    }

    public static void inicializarAPI(String accessToken) {

         spotifyApi = new SpotifyApi.Builder()
                .setAccessToken(accessToken).build();
    }

    public static void buscarMusica() {
        var request = spotifyApi.getUsersTopTracks().build();

        try {
            final Paging<Track> pagingTrack = request.execute();


            Track[] tracks = request.execute().getItems();


            int position = 1;

            System.out.println("=======================TOP MUSICAS OUVIDAS====================");

            for (Track track : tracks) {

                String trackId = track.getName();

                String trackName = track.getArtists()[0].getName();

                System.out.println(trackId + " - " + trackName);
                position++;


            }

            System.out.println("========================================");
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Erro ao buscar musica: " + e.getMessage());
        }

        try{
            final CompletableFuture<Paging<Track>> trackPagingCompletableFuture = request.executeAsync();

            final Paging<Track> trackPaging = trackPagingCompletableFuture.join();

            System.out.println("Total:" + trackPaging.getTotal());

        } catch (CompletionException | CancellationException e) {
            System.out.println("Error" + e.getCause().getMessage());

        }



    }

}
