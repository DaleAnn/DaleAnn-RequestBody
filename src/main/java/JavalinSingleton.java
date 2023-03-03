

import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;


/**
 * Background: A json string representing a song will be sent in this POST request with the following fields: 
 *      songName, artistName
 */
public class JavalinSingleton {

    public static Javalin getInstance(){
        Javalin app = Javalin.create();
        ObjectMapper om = new ObjectMapper();
        
        /**
         * problem1: retrieve the song object from the request body...
         *      1. return the song object as JSON in the response body.
         * 
         * Note: Please refer to the "RequestBody.MD" file for more assistance.
         */
        app.post("/echo", ctx -> {
            
            //implement logic here //

            //retrieve the json string from the request body
            String songFromJson = ctx.body();

            //utilize jackson to convert the json string to a song object
            Song song = om.readValue(songFromJson, Song.class);

        //now we can use the 'song' response body as a Java object in whatever way we see fit.
       //return the song as the response body, but also have Javalin convert it to JSON 

            ctx.json(song);
                       
        });

        /**
         * problem2: retrieve the song object from the request body...
         *      1. update the artist in the song object to "Beatles"
         *      2. return the updated song object as JSON in the response body
         * 
         * Note: Please refer to the "RequestBody.MD" file for more assistance.
         */
        app.post("/changeartisttobeatles", ctx -> {

            //implement logic here
            //manipulating 'song' as a java object 
            //update the artist in the song object to "Beatles"

            String songFromJson = ctx.body();
            Song song = om.readValue(songFromJson, Song.class);
            song.artistName("Beatles");

      //generate an HTTP response with the user object in the response body as a JSON.
      // return the updated song object as JSON in the response body

            ctx.json(song);         
               
        });

        return app;
    }
    
}
