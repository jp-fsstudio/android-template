package com.fsstudio.template.rx;

import lombok.Data;
import org.jetbrains.annotations.NotNull;


public abstract @Data class RxModule {
  protected final @NotNull RxActivity activity;

  protected RxModule(@NotNull RxActivity activity) {
    this.activity = activity;
  }
}
