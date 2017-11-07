package com.service;

import java.io.InputStream;

public interface FileDownloadService {
    InputStream getInputStream(String target);
}
