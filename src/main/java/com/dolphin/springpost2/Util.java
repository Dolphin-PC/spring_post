package com.dolphin.springpost2;

import com.dolphin.springpost2.Domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.*;
import java.util.stream.Stream;

public class Util {

    public static <T> Map<String, Object> setPagination(Page<T> list, Pageable pageable) {
        Map<String, Object> resultMap = new HashMap<>();


        List<Integer> totalPageList = Arrays.asList(
                Stream.iterate(0, n -> n + 1)
                      .limit(list.getTotalPages())
                      .toArray(Integer[]::new)
        );


        resultMap.put("prev", pageable.previousOrFirst().getPageNumber());
        resultMap.put("next", pageable.next().getPageNumber());
        resultMap.put("hasPrev", list.hasPrevious());
        resultMap.put("hasNext", list.hasNext());
        resultMap.put("totalPageList", totalPageList);
        resultMap.put("currentPageNumber", pageable.getPageNumber());
        return resultMap;
    }
}
