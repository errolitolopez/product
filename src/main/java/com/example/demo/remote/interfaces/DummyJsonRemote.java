package com.example.demo.remote.interfaces;

import com.example.demo.remote.model.DummyJsonProduct;

public interface DummyJsonRemote {
    DummyJsonProduct products(Long id);
}
