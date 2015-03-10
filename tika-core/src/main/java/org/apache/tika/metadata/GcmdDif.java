package org.apache.tika.metadata;

/*
 * Lots of nested structures and metadata. Below is just a sample
 * 
 */

public interface GcmdDif {
	
	public static final String NAMESPACE_URI_GCMD = "http://gcmd.gsfc.nasa.gov/Aboutus/xml/dif/";
    public static final String PREFIX_GCMD = "gcmd";
    
    Property Entry_ID = Property.internalText(
    		PREFIX_GCMD + Metadata.NAMESPACE_PREFIX_DELIMITER + "entry_id");

    /*Property Version = Property.internalText(
    		PREFIX_GCMD + Metadata.NAMESPACE_PREFIX_DELIMITER + "version");
    
    Property Version_Description = Property.internalText(
    		PREFIX_GCMD + Metadata.NAMESPACE_PREFIX_DELIMITER + "version_description");*/
    
    Property Entry_Title = Property.internalText(
    		PREFIX_GCMD + Metadata.NAMESPACE_PREFIX_DELIMITER + "entry_title");
    
    Property Dataset_Citation = Property.internalText(
    		PREFIX_GCMD + Metadata.NAMESPACE_PREFIX_DELIMITER + "dataset_citation");
    
    Property Personnel = Property.internalText(
    		PREFIX_GCMD + Metadata.NAMESPACE_PREFIX_DELIMITER + "personnel");
    
    Property Science_Keywords = Property.internalText(
    		PREFIX_GCMD + Metadata.NAMESPACE_PREFIX_DELIMITER + "science_keywords");
    
    Property ISO_Topic_Category = Property.internalText(
    		PREFIX_GCMD + Metadata.NAMESPACE_PREFIX_DELIMITER + "iso_topic_category");
    
    Property Ancillary_Keyword = Property.internalText(
    		PREFIX_GCMD + Metadata.NAMESPACE_PREFIX_DELIMITER + "ancillary_keyword");
    
    Property Platform = Property.internalText(
    		PREFIX_GCMD + Metadata.NAMESPACE_PREFIX_DELIMITER + "platform");
    
    Property Temporal_Coverage = Property.internalText(
    		PREFIX_GCMD + Metadata.NAMESPACE_PREFIX_DELIMITER + "temporal_coverage");
    
    Property Spatial_Coverage = Property.internalText(
    		PREFIX_GCMD + Metadata.NAMESPACE_PREFIX_DELIMITER + "spatial_coverage");
    
    Property Summary = Property.internalText(
    		PREFIX_GCMD + Metadata.NAMESPACE_PREFIX_DELIMITER + "summary");
    
}
