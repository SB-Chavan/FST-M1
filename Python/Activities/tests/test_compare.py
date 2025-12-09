import pytest

@pytest.mark.great
def test_greater():
    assert 5 > 2

@pytest.mark.great
def test_greater_equal():
    assert 6 >= 6

@pytest.mark.other
def test_lesser():
    assert 2 < 5
