package br.com.paygo.gateway.sdk.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Arrays;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Setter
@Getter
public class Pix {

    PixProvider provider;
    List<PixKeyField> key;

    public static Pix of(PixProvider provider, PixKeyField... keys) {
        Pix pix = new Pix();
        pix.setProvider(provider);
        pix.setKey(Arrays.asList(keys));
        return pix;
    }

}
