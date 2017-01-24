# Demos
Demo Repo for Sample Projects

Note: Master branch cannot be built, please use one of the feature branches to compile and test one of the demos.

This repository is meant to be a work in progress. With that said, anything here is subject to change and should be used as a reference rather than copying directly into any production applications.

First Set of Demo's will be centered around Lists, mainly ListView & RecyclerView and their various applications.

[ListViewDemo] (https://github.com/kylejablonski/Demos/tree/sample/ListViewDemo) - Purpose for this demo is to show the (old) ViewHolder pattern for ListView. This can still be used in production but the newer RecyclerView is recommended. For simple lists, RecyclerView may be overkill, so if you have something thats not too complex ListView is a good option.

[ListView ArrayAdapterDemo] (https://github.com/kylejablonski/Demos/tree/sample/ListViewArrayAdapterDemo) - Purpose of this demo is to show the use of an ArrayAdapter with a custom data type. ArrayAdapters are pretty usefull when displaying simple data in a list, this demo displays a bit more complex data. In a custom object override the toString() method to return the value you want to supply to the TextView in the ArrayAdapter.

[RecyclerView Demo] (https://github.com/kylejablonski/Demos/tree/sample/RecyclerViewDemo) - Purpose for this demo is to show the usage of a RecyclerView. RecyclerView works a bit differently then a ListView in that it enforces the ViewHolder pattern and requires a layout manager to facilitate the display of the data.
