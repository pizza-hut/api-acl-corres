package org.owlet.corres.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Output
{
	@JsonProperty("outputName")
    private String outputName;

	@JsonProperty("output-type")
    private String output_type;

	@JsonProperty("outputType")
    private String outputType;

	@JsonProperty("output-name")
    private String output_name;

	@JsonProperty("outputName")
    public String getOutputName ()
    {
        return outputName;
    }

	@JsonProperty("outputName")
    public void setOutputName (String outputName)
    {
        this.outputName = outputName;
    }

    @JsonProperty("output-type")
    public String getOutput_type ()
    {
        return output_type;
    }

    @JsonProperty("output-type")
    public void setOutput_type (String output_type)
    {
        this.output_type = output_type;
    }

    @JsonProperty("outputType")
    public String getOutputType ()
    {
        return outputType;
    }

    @JsonProperty("outputType")
    public void setOutputType (String outputType)
    {
        this.outputType = outputType;
    }

    @JsonProperty("output-name")
    public String getOutput_name ()
    {
        return output_name;
    }

    @JsonProperty("output-name")
    public void setOutput_name (String output_name)
    {
        this.output_name = output_name;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [outputName = "+outputName+", output-type = "+output_type+", outputType = "+outputType+", output-name = "+output_name+"]";
    }
}