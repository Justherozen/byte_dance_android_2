
public int getAllChildViewCount(View view) {
        /*
         对根布局进行一次preorder traversal，记录遍历到的ViewGroup和View的总数
         */

        if(view == null)return 0;
        if(!(view instanceof ViewGroup))return 1;
        //若是ViewGroup,对其所有子view递归遍历，sum记录子树总节点数
        int i,sum = 1;
        ViewGroup vg = (ViewGroup) view;
        for (i=0;i<vg.getChildCount();++i){
			sum += getAllChildViewCount(vg.getChildAt(i));
		}
     return sum;
    }
      