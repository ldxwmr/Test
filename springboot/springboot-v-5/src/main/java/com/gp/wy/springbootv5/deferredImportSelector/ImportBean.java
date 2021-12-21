package com.gp.wy.springbootv5.deferredImportSelector;

import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * @Author ldxwmr
 * @Date 2021/12/20 14:07
 */
@Component
@Import(DeferredImportSelectorDemo.class)
public class ImportBean {
}
