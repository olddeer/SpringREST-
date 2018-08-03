package at.bitmedia.schoolreader.service;

import at.bitmedia.schoolreader.entity.Result;

public interface ResultService extends GenericService<Result> {

    Result insertResult(Result r);
}
