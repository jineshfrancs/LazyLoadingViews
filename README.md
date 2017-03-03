# LazyLoadingViews
Loading effect for the child views in Adapter View before binding data from service. 

![Output sample](https://github.com/jineshfrancs/LazyLoadingViews/blob/master/screens/loading.gif)

Just add the loading views in adapter layout.
```
  <test.jinesh.loadingviews.LoadingTextView
            android:layout_width="match_parent"
            android:textColor="#000"
            android:id="@+id/city"
            android:layout_margin="5dp"
            android:layout_weight="1"
            android:gravity="center_vertical"
            android:textSize="18sp"
            android:layout_height="0dp" />
			
```
Call ```startLoading()``` to show loading effect on views.

```
    LoadingTextView cityText = (LoadingTextView) view.findViewById(R.id.city);
	cityText.startLoading();
```

Call ```stopLoading()``` to hide loading effect on views.

```
cityText.stopLoading();

```