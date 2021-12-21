package com.gp.wy.springbootv5.deferredImportSelector;

import org.assertj.core.util.Strings;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ldxwmr
 * @Date 2021/12/20 13:58
 */
public class DeferredImportSelectorDemo implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        System.out.println("================DeferredImportSelectorDemo.selectImports===============");
        // 如果需要把类实例化，就需要把该类的完整限定名返回
        return new String[]{DeferredBean.class.getCanonicalName()};
    }
    // 这里要返回实现了Group接口的类

    @Override
    public Class<? extends Group> getImportGroup() {
        return DeferredImportSelectorGroupDemo.class;
    }

    private static class DeferredImportSelectorGroupDemo implements Group{

        List<Entry> list = new ArrayList<>();

        /**
         *
         * @param metadata
         * @param selector
         * 收集需要实例化的类
         */
        @Override
        public void process(AnnotationMetadata metadata, DeferredImportSelector selector) {
            System.out.println("================DeferredImportSelectorGroupDemo.process===============");
            String[] strings = selector.selectImports(metadata);
            for (String string : strings) {
                list.add(new Entry(metadata,string));
            }
        }


        // 负责把process收集的结果返回，返回的类必须包装秤entry对象
        @Override
        public Iterable<Entry> selectImports() {
            System.out.println("==============DeferredImportSelectorGroupDemo.selectImports===========");

            return list;
        }
    }
}
