package kr.rhinitis.secondduoproject.util.dto;

import lombok.Getter;
import org.springframework.data.domain.Page;

@Getter
public class PageInfo {
    private int page;
    private int size;
    private long totalElements;
    private int totalPages;

    public <T> PageInfo(Page<T> page) {
        this.page = page.getNumber() + 1;
        this.size = page.getSize();
        this.totalElements = page.getTotalElements();
        this.totalPages = page.getTotalPages();
    }
}
