package com.rabraham.principles.solid.S.impl;

import com.rabraham.principles.solid.S.Page;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

@Getter
@Setter
@AllArgsConstructor
public class PageImpl implements Page {
    private Integer pageNumber;
    private String text;

    public boolean containsText(String text) {
        return StringUtils.contains(this.text, text);
    }
}
