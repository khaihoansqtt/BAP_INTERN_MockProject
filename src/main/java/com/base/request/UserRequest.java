package com.base.request;

import lombok.*;

import javax.validation.constraints.Size;
import java.util.List;
import java.util.Map;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class UserRequest extends BaseRequest {
  @Size(
          min = 2,
          max = 35,
          message = "name must be 2-35 characters long."
  )
  private String name;

  private Integer page;

  private Integer size;

  private List<Map<String, String>> order;
}