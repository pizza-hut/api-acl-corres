package org.owlet.corres.service;

import org.owlet.corres.model.CorresJobRequest;
import org.owlet.corres.model.CorresJobResponse;
import org.owlet.corres.model.CorresStatusResponse;


public interface AclCorresService {

	CorresJobResponse submitJob(CorresJobRequest req) throws Exception;

	CorresStatusResponse getStatus(String siteId, String jobId) throws Exception;

}
