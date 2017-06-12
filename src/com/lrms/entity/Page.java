package com.lrms.entity;


/**
 * @author songyx
 *
 */
public class Page {
		private int everyPage;      //每页记录数
		private int totalCount;     //总记录数
		private int totalPage;      //总页数
		private int currentPage;    //当前页码
		private int beginIndex;     //开始的记录数
		private boolean hasPrePage; //是否有上一页
		private boolean hasNextPage;//是否有下一页

		public Page(int everyPage, int totalCount, int totalPage, int currentPage,
				int beginIndex, boolean hasPrePage, boolean hasNextPage) {
			this.everyPage = everyPage;
			this.totalCount = totalCount;
			this.totalPage = totalPage;
			this.currentPage = currentPage;
			this.beginIndex = beginIndex;
			this.hasPrePage = hasPrePage;
			this.hasNextPage = hasNextPage;
		}

		public Page(){}
		
		public int getEveryPage() {
			return everyPage;
		}

		public void setEveryPage(int everyPage) {
			this.everyPage = everyPage;
		}

		public int getTotalCount() {
			return totalCount;
		}

		public void setTotalCount(int totalCount) {
			this.totalCount = totalCount;
		}

		public int getTotalPage() {
			return totalPage;
		}

		public void setTotalPage(int totalPage) {
			this.totalPage = totalPage;
		}

		public int getCurrentPage() {
			return currentPage;
		}

		public void setCurrentPage(int currentPage) {
			this.currentPage = currentPage;
		}

		public int getBeginIndex() {
			return beginIndex;
		}

		public void setBeginIndex(int beginIndex) {
			this.beginIndex = beginIndex;
		}

		public boolean isHasPrePage() {
			return hasPrePage;
		}

		public void setHasPrePage(boolean hasPrePage) {
			this.hasPrePage = hasPrePage;
		}

		public boolean isHasNextPage() {
			return hasNextPage;
		}

		public void setHasNextPage(boolean hasNextPage) {
			this.hasNextPage = hasNextPage;
		}

}
