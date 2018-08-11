package nfwya.alterg.controller.greeting;


import com.fasterxml.jackson.annotation.JsonProperty;


public class Greeting
{
    private final Integer id;

    private final String content;


    public Greeting(final Integer id, final String content)
    {
        this.id = id;
        this.content = content;
    }


    @JsonProperty("id")
    public Integer getId()
    {
        return id;
    }


    @JsonProperty("content")
    public String getContent()
    {
        return content;
    }


    @Override
    public String toString()
    {
        return "Greeting{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
