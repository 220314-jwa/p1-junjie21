package SPMS;

import javafx.scene.input.DataFormat;

public class Story_Pitch {
    private int pitch_id;
    private String description;
    private String tentative_title;
    private DataFormat expected_time;
    private String length_type;
    private String blurb;

    // default constructor
    public Story_Pitch(){
    pitch_id = 0;
    description = "";
    tentative_title = "";
    expected_time = getExpected_time();
    length_type = "";
    blurb = "";
    }

    public void setBlurb(String blurb) {
        this.blurb = blurb;
    }

    public void setLength_type(String length_type) {
        this.length_type = length_type;
    }

    public void setExpected_time(DataFormat expected_time) {
        this.expected_time = expected_time;
    }

    public void setTentative_title(String tentative_title) {
        this.tentative_title = tentative_title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPitch_id(int pitch_id) {
        this.pitch_id = pitch_id;
    }

    public String getBlurb() {
        return blurb;
    }

    public String getLength_type() {
        return length_type;
    }

    public DataFormat getExpected_time() {
        return expected_time;
    }

    public String getTentative_title() {
        return tentative_title;
    }

    public String getDescription() {
        return description;
    }

    public int getPitch_id() {
        return pitch_id;
    }

    public String toString(){
        return "pitch id: " + pitch_id;
    }

    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + pitch_id;
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((tentative_title == null) ? 0 : tentative_title.hashCode());
        result = prime * result + pitch_id;
        result = prime * result + pitch_id;


        return result;
    }
}
