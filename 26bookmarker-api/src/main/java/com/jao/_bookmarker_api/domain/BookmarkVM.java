package com.jao._bookmarker_api.domain;

import java.time.Instant;

public interface BookmarkVM {
	 Long id();
     String title();
     String url();
     Instant createdAt();
}
